# Written by James Thurlow
# Date: 12/4/2023
# This file impliments the cosine similarity function with the chatbot.


# Import Statements
from typing import Any, Text, Dict, List

from rasa_sdk import Action, Tracker
from rasa_sdk.executor import CollectingDispatcher
import vector_comparison

from rasa_core.agent import Agent
from rasa_core.interpreter import RasaNLUInterpreter
#from rasa_core.run import serve_application

class ActionCheckSymptom(Action):

    def name(self) -> Text:
        return "action_check_symptom"
    
    def run(self, dispatcher: CollectingDispatcher,
            tracker: Tracker,
            domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:

        user_input = tracker.latest_message['text']

        best_matches = vector_comparison.best_matches(user_input)
        msg = f"Based on the symptoms entered, I believe you have: " + user_input + "\n" + best_matches[0][1] + "\n" + best_matches[1][1] + "\n" + best_matches[2][1]  
        dispatcher.utter_message(text=msg)

        return []
