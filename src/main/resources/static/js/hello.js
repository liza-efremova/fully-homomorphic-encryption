var myApp = angular.module('hello', []);
myApp.controller('encoder', function($http) {
        var self = this;

        self.encode = function() {
            $http.get('/encode/', {params: {'opendata1': self.opendata1, 'opendata2': self.opendata2}}).then(function(response) {
                MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
                self.encodedData = response.data;
                MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
                self.encoded = true;
                MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            });
        };

        self.performOperations = function () {
            $http.get('/perform/', {params: {'opendata1': self.encodedData.opendata1,
                'opendata2': self.encodedData.opendata1, 'operation': self.operation}})
                .then(function(response) {
                MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
                self.computedData = response.data;
                MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
                self.computed = true;
                MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
            });
        }
    });