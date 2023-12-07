#Written By James Thurlow
#Meical Chatbot
#4 DEC 2023

This is a Rasa chatbot with custom action implimentation of a Consine Similarity function. The purpose of this program is for the user to be able to communiicate with the
chatbot and enter symptoms and the chatbot returns the most likely disease. 

To run this program, your python version must be Python 3.8 or lower to be compatible with Rasa (Which does not support the most current version of Python) or operate in a
Python container. Run the Actions Server with the command "rasa run actions" and run the chatbot with the command "rasa shell". 

Enter any input you would like. The chatbot will hold a basic conversation with you unless you wish to enter symptoms, in which case it will recognize those symtoms and
check for your disease.