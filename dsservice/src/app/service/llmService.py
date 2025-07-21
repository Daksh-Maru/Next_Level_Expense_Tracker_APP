import os
from langchain_core.prompts import ChatPromptTemplate
from langchain_mistralai import ChatMistralAI
from service.Expense import Expense
from dotenv import load_dotenv
import traceback

class LLMService:
    def __init__(self):
        load_dotenv()
        self.prompt = ChatPromptTemplate.from_messages([
            (
                "system",
                "You are an expert extraction algorithm. "
                "Only extract relevant information from the text. "
                "If you do not know the value of an attribute asked to extract, "
                "return null for the attribute's value.",
            ),
            ("human", "{text}")
        ])
        self.apiKey = os.getenv('MISTRALAI_API_KEY')
        self.llm = ChatMistralAI(apiKey = self.apiKey, model='mistral-large-latest', temperature=0)
        self.runnable = self.prompt | self.llm.with_structured_output(schema=Expense)

    def runLLM(self, message):
        try:
            print(f"Sending message to LLM: {message}")
            print(f"The api key is : {self.apiKey}")
            response = self.runnable.invoke({"text": message})
            print(f"Raw response from LLM: {response}")
            return response
        except Exception as e:
            traceback.print_exc()
            print(f"An error occurred: {e}")
            return None