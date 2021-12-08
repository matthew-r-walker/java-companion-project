'use strict';

angular.module('MGL_Task1_app').controller('MGL_Task1_Controller',
		[ 'MGL_Task1_Service', function(MGL_Task1_Service) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				MGL_Task1_Service.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return MGL_Task1_Service.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.deleteGame = function(gameToDelete){
				return MGL_Task1_Service.deleteGame(gameToDelete.id).then( function() {
					self.fetchAllGames();
				});
			}
			
			self.selectGame = function(gameToUpdate){
				self.game = angular.copy(gameToUpdate);
			}
			
			self.resetForm = function() {
				self.game = {};
			}
			
			self.updateGame = function() {
				return MGL_Task1_Service.updateGame(self.game).then( function() {
					self.fetchAllGames();
				});
			}

			self.fetchAllGames();
		} ]);
