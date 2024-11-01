import customtkinter 
from Game import Game

class App(customtkinter.CTk):
    def __init__(self):
        super().__init__()
        self.title('Deep Sea 2')
        self.geometry('800x600')
        customtkinter.set_appearance_mode('light')
        self.grid_rowconfigure(0, weight=1)
        self.grid_columnconfigure(0, weight=1)

        self.my_frame = Game(master=self)
        self.my_frame.grid(row=0, column=0, padx= 20, pady= 20, sticky="nsew")

app = App()
app.mainloop()


