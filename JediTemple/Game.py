import customtkinter as ctk

class Game(ctk.CTkFrame):
    def __init__(self, master, **kwargs):
        super().__init__(master, **kwargs)
        
        self.frame_matrix = []

        self.create_matrix(15, 15)

    def create_matrix(self, rows, columns):
        for row in range(rows):
            row_frames = []

            for column in range(columns):
                frame = ctk.CTkFrame(master= self, width= 40, height= 40, corner_radius=5)
                frame.grid(row= row, column= column, padx= 2, pady= 2)
                row_frames.append(frame)

                label = ctk.CTkLabel(master= frame, text= f"{row}, {column}", font= ("Arial", 8))
                label.pack(expand=True)

            self.frame_matrix.append(row_frames)

    def change_frame_color(self, row, column, color):
        self.frame_matrix[row][column].configure(fg_color= color)


