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
			self.genres = [{name: 'All'}]; 
			self.selectedGenre = 'All';
			
			

			self.fetchAllGames = function(){
				if(self.selectedGenre == 'All'){
					MGL_Task1_Service.fetchAllGames().then(function(data) {
						self.games = data;
						if(self.games.length > 0){
							self.genres = parseGenres();	
						}else{
							self.genres = [{name: 'All'}];//clear
						}
					})
				} else {
					MGL_Task1_Service.filterByGenre(self.selectedGenre).then( function(data) {
						self.games = data;
					});
				}
			}
			
			function parseGenres(){
				var strArray = [];
				var genreArray = [{name: 'All'}];
				self.games.forEach((game) =>{
					strArray.push( game.genre );
				})
				//sets cannot contain duplicate values. voila! all genres no duplictes. 
				strArray = Array.from( new Set(strArray));
				//lets make an object list for easy handling.
				strArray.forEach((genre) =>{
					genreArray.push({ name : genre });
				})
				return genreArray;
			}

			self.addGame = function(){
				return MGL_Task1_Service.createGame(self.game).then( function() {
					self.fetchAllGames();
					self.game = {};
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
					self.game = {};
				});
			}

			self.fetchAllGames();
		} ]);
