import customtkinter as ctk

class Board(ctk.CTk):
    def __init__(self, master, rows: int, columns: int, click_callback= None):
        self.master = master
        self.rows = rows
        self.columns = columns
        self.frame_matrix = []
        self.click_callback = click_callback # Callback for handling cell clicks
        self.highlighted_cells = set()
        self.occupied_cells = set()

        self.create_matrix()
    
    def create_matrix(self) -> None:
        """Creates and appends a matrix representing the board map to `self.frame_matrix`"""
        for row in range(self.rows):
            row_frames = []

            for column in range(self.columns):
                frame = ctk.CTkFrame(master= self.master, width= 40, height= 40, corner_radius=5)
                frame.grid(row= row, column= column, padx= 2, pady= 2)
                frame.grid_propagate(False)
                frame.pack_propagate(False)
                frame.bind("<Button-1>", lambda event, r=row, c= column: self.on_cell_click(r, c))

                # Adds an onclick event to move the active player
                row_frames.append(frame)

            self.frame_matrix.append(row_frames)
        
    def on_cell_click(self, row, column):
        """Handles the cell clicks and passes the event to the callback."""
        if (row, column) in self.highlighted_cells:
            if self.click_callback:
                self.click_callback(row, column)
            
        else:
            print(f"Invalid move: Cell ({row}, {column}) is not highlighted.")
        
    def highlight_cells(self, cells, color = "blue") -> None:
        """Highlights the selected cells with a color of choice."""
        self.clear_highlights()

        self.highlighted_cells = set(cells) # Stores highlighted cells
        for r, c in cells:
            self.frame_matrix[r][c].configure(border_color = color, border_width = 2)

    def clear_highlights(self):
        """Clears all highlighted frames by resetting the border."""
        self.highlighted_cells.clear()

        for row in self.frame_matrix:
            for frame in row:
                frame.configure(border_color= "black", border_width = 0)
    
    def is_occupied(self, row, column):
        return (row, column) in self.occupied_cells
    
    def occupy(self, row, column):
        self.occupied_cells.add((row, column))
    
    def release(self, row, column):
        self.occupied_cells.discard((row, column))
    
    def place_item(self, row, column):
        if not self.is_occupied(row, column):
            self.occupy(row, column)
        else:
            raise ValueError(f"Cell ({row}, {column}) is already occupied!")