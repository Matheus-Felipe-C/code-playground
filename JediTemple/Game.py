import customtkinter as ctk
from player import Player
from treasure import Treasure
from board import Board
from dice import Dice
from player_manager import PlayerManager
from treasure_manager import TreasureManager
from bomb_manager import BombManager

class Game(ctk.CTkFrame):
    def __init__(self, master, rows = 15, columns = 15, difficulty = 'hard', **kwargs):
        super().__init__(master, **kwargs)

        # Core components
        self.board = Board(self, rows, columns, click_callback=self.handle_cell_click)
        self.difficulty = difficulty
        self.player_manager = PlayerManager(self.board, 150)
        
        # Initialize bomb and treasure managers after player_manager
        self.bomb_manager = BombManager(self.board, self.difficulty)
        self.treasure_manager = TreasureManager(self.board, self.difficulty)

        self.dice = Dice()

        # Add players
        self.player_manager.add_player(symbol="👾", board=self.board, name="Player 1", initial_row=0, initial_column=0)
        self.player_manager.add_player(symbol="🦄", board=self.board, name="Player 2", initial_row=0, initial_column=1)

        # UI
        self.instructions_label = ctk.CTkLabel(self, text="Click to move active player, press 'Tab' to switch players")
        self.instructions_label.grid(row=rows + 1, column=0, columnspan=columns, pady=10)
        

        self.bind("<Tab>", lambda event: self.player_manager.switch_to_next_player(has_moved=False))

        self.setup_game()

    def setup_game(self):
        dice_roll = self.dice.roll()
        active_player = self.player_manager.get_active_player()
        
        self.player_manager.get_possible_moves(active_player, dice_roll)

    def handle_cell_click(self, row, column):
        """Handles the cell click and moves the player."""
        self.player_manager.move_player(row, column)
        self.bomb_manager.check_for_bomb(row, column, self.player_manager)
        self.treasure_manager.check_for_treasure(row, column, self.player_manager.get_active_player())

    def roll_dice(self):
        """Rolls the dice to determine how many steps a player can move"""
        dice_roll = self.dice.roll()

        self.player_manager.show_possible_moves(dice_roll)
