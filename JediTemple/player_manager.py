from board import Board
from player import Player
from dice import Dice

class PlayerManager:
    def __init__(self, board, oxygen):
        self.board = board
        self.players = []
        self.active_player_index = 0
        self.oxygen = oxygen
        self.possible_moves = [] # Stores the player's possible moves
        self.dice = Dice()

    def add_player(self, board, symbol, name, initial_row, initial_column):
        player = Player(self.board, symbol, name, initial_row, initial_column)
        self.players.append(player)
    
    def switch_to_next_player(self, has_moved=True):
        if not has_moved:
            self.consume_oxygen(0)
            
        self.active_player_index = (self.active_player_index + 1) % len(self.players)
        active_player = self.get_active_player()
        print(f"Active player is now {active_player.name}")
    
        self.board.clear_highlights()
        self.get_possible_moves(active_player, self.dice.roll())
    
    def move_player(self, row, column):
        player = self.get_active_player()

        if self.is_occupied(row, column):
             # Attempts a jump if the target cell is occupied
             row, column = self.attempt_jump(player, row, column)
            
        # Verify if the final target position is in possible moves
        if (row, column) not in self.possible_moves:
            print(f"Move to ({row}, {column}) is invalid.")
            return

        cells_traveled = abs(player.row - row) + abs(player.column - column)
        player.move_to(row, column)
        self.consume_oxygen(cells_traveled)

    def is_occupied(self, row: int, column: int) -> bool:
        """Checks if a specific position is occupied by any player."""
        return any(player.row == row and player.column == column for player in self.players)

    def consume_oxygen(self, cells_traveled):
        player = self.get_active_player()
        consumption = cells_traveled * player.weight + 1
        self.oxygen -= consumption
        
        print(f"Oxygen consumed: {consumption}. Remaining oxygen: {self.oxygen}")

    def get_possible_moves(self, active_player, dice_roll):
        row, column = active_player.row, active_player.column
        self.possible_moves = [] # Resets the possible moves tuple

        # Collect possible moves (up, down, left, right) within the dice roll range
        for step in range(1, dice_roll + 1):
            # Up
            if row - step >= 0:
                self.possible_moves.append((row - step, column))
            
            # Down
            if row + step < len(self.board.frame_matrix):
                self.possible_moves.append((row + step, column))
            
            # Left
            if column - step >= 0:
                self.possible_moves.append((row, column - step))
            # Right
            if column - step < len(self.board.frame_matrix[0]):
                self.possible_moves.append((row, column + step))
            
            self.board.highlight_cells(self.possible_moves)
        
    def attempt_jump(self, player, row, column):
        """Attempts to jump over an occupied cell."""
        # Determine the direction and calculate jump position
        d_row, d_col = row - player.row, column - player.column
        new_row, new_column = row + d_row, column + d_col

        # Ensure the jump position is within bounds and unoccupied
        if (0 <= new_row < len(self.board.frame_matrix) and 
            0 <= new_column < len(self.board.frame_matrix[0]) and
            not self.is_occupied(new_row, new_column)):
            return new_row, new_column  # Successful jump target
        return player.row, player.column  # Return original position if jump fails
    
    def kill_player(self, player):
        """Removes a player from the game."""
        self.players.remove(player)
        print(f"{player.name} has been removed from the game.")
        player.remove()
        
        if not self.players:
            print("All players are dead! Game Over.")
        else:
            self.switch_to_next_player()

    def get_active_player(self):
        return self.players[self.active_player_index]
    