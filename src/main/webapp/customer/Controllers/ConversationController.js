/**
 * Created by anuradhawick on 9/8/16.
 */
angular.module("lei-admin").controller("ConversationController", function ($scope) {
    $scope.conversation = [];
    $scope.fetchedArray = [];
    $scope.advertisements = [];
    $scope.addPriorityHigh = true;
    $scope.addTimeout = Date.now();
    $scope.type = '';
    $scope.arrayobjects = [];
    $scope.location = false; // disable map display at the begining
    $scope.activeImage = $scope.advertisements[0];
    let activeImageIndex = 0;

    // Floor map props
    let selectedSVGColor = null;
    let selectedSVGId = null;

    $scope.updateAdds = function () {
        // loading advertisements
        let data = null;
        let xhr = new XMLHttpRequest();
        xhr.withCredentials = true;
        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === this.DONE) {
                $scope.advertisements = JSON.parse(this.responseText);
                $scope.$apply();
            }
        });
        xhr.open("GET", "http://localhost:8080/lei-api/advertisement-management/get-ads");
        xhr.send(data);
    };


        if (!('webkitSpeechRecognition' in window)) {
//        upgrade();
        } else {
            recognition = new webkitSpeechRecognition();
            recognition.continuous = true;
            recognition.interimResults = true;

            recognition.onstart = function () {
                console.log('Started')
            };

            recognition.onresult = function (event) {
                let interim_transcript = '';

                for (let i = event.resultIndex; i < event.results.length; ++i) {
                    final_transcript = '';
                    interim_transcript = '';
                    if (event.results[i].isFinal) {
                        final_transcript += event.results[i][0].transcript;

                        $('#chat-input').val(final_transcript);
                        $scope.sendClick();
                    } else {
                        interim_transcript += event.results[i][0].transcript;
                        $('#chat-input').val(interim_transcript);
                    }
                }
            };

            recognition.onerror = function (event) {
            };

            recognition.onend = function () {
                console.log('Finished');
            };
        }

        $scope.speak = function (text) {
            var msg = new SpeechSynthesisUtterance();
            var voices = window.speechSynthesis.getVoices();
            msg.voice = voices[10]; // Note: some voices don't support altering params
            msg.voiceURI = 'native';
            msg.volume = 1; // 0 to 1
            msg.rate = 1; // 0.1 to 10
            msg.pitch = 2; //0 to 2
            msg.text = text;
            msg.lang = 'en-US';
            speechSynthesis.speak(msg);
        }

    $scope.init = function () {
        $scope.svg = Snap('#svgdiv');
    };

    $scope.fetchAiResponse = function (query) {
        let data = null;

        let xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === this.DONE) {
                $scope.location = false;
                let responseJSON = JSON.parse(this.responseText);
                $scope.aiMsg(responseJSON.message);
                $scope.type = responseJSON.type;

                $scope.arrayobjects = responseJSON.array;
                $scope.addTimeout = Date.now();
                $scope.addPriorityHigh = false;
                $scope.resetFloor();
                switch (responseJSON.type) {
                    case 'location':
                        $scope.location = true;
                        $scope.$apply();
                        $scope.init();
                        $scope.markFloor(responseJSON.array[0].name);
                        $scope.$apply();
                        break;
                }
                $scope.$apply();
                $scope.scroll();
            }
        });

        xhr.open("GET", "http://localhost:8080/lei-api/?query=" + query);
        xhr.setRequestHeader("content-type", "application/json");

        xhr.send(data);
    };

    $scope.start = function () {
        final_transcript = '';
        recognition.lang = "en-US";
        recognition.start();
    };

    $scope.customerMsg = function (msg) {
        $scope.conversation.push({ai: false, msg: msg});
        $scope.scroll();
    };

    $scope.aiMsg = function (msg) {
        $scope.conversation.push({ai: true, msg: msg});
        $scope.speak(msg);
        $scope.scroll();
    };

    $scope.scroll = function () {
        $("#panel-body").animate({scrollTop: $("#chat-list").height()}, 1000);
    };

    $scope.sendClick = function () {
        if ($scope.inputMessage == undefined) return;
        $scope.customerMsg($scope.inputMessage);
        $scope.fetchAiResponse($scope.inputMessage);

        $('#chat-input').val('');
    };

    $scope.keyUpEvent = function (event) {
        if ($scope.inputMessage == undefined) return;
        if (event.keyCode == 13) {
            $scope.sendClick();
        }
    };

    $scope.addPriorityExpire = function () {
        setInterval(function () {
            if ($scope.addTimeout + 5000 < Date.now()) {
                $scope.addPriorityHigh = true;
                $scope.conversation = [];
                $scope.$apply();
            }
        }, 20000);
    };

    $scope.markFloor = function (svgId) {
        let targetSvg = $scope.svg.select("#" + svgId);
        if (selectedSVGId) {
            $scope.svg.select("#" + selectedSVGId).attr({fill: selectedSVGColor});
        }
        selectedSVGColor = targetSvg.attr().fill;
        selectedSVGId = targetSvg.attr().id;
        targetSvg.attr({fill: "#f00"});
    };

    $scope.resetFloor = function () {
        if (selectedSVGId) {
            $scope.svg.select("#" + selectedSVGId).attr({fill: selectedSVGColor});
            selectedSVGColor = null;
            selectedSVGId = null;
        }
    };

    $scope.addPriorityExpire();
    $scope.updateAdds();
    $scope.start();

    setInterval(function () {
        if (activeImageIndex == $scope.advertisements.length - 1) {
            activeImageIndex = 0;
        } else {
            activeImageIndex++;
        }
        $scope.activeImage = $scope.advertisements[activeImageIndex];
        $scope.$apply();
    }, 2000);
});