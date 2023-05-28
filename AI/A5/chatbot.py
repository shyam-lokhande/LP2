import nltk
from nltk.chat.util import Chat, reflections

# Define the patterns and responses
patterns = [
    (r"hello|hi|hey", ["Hello there!", "Hi!", "Hey!"]),
    (r"how are you?", ["I'm doing well, thank you!", "I'm fine, thanks for asking."]),
    (r"what can you do?", ["I can provide information about medical conditions, treatments, and symptoms."]),
    (r"what is (.*?)", ["Sorry, I'm not qualified to diagnose medical conditions. It's best to consult a healthcare professional for an accurate diagnosis."]),
    (r"what are the symptoms of (.*?)", ["The symptoms of {0} can vary, but may include fever, cough, sore throat, and difficulty breathing."]),
    (r"how is (.*?) treated", ["The treatment for {0} depends on the underlying cause. It's best to consult a healthcare professional for personalized treatment advice."]),
    (r"what are some common treatments for (.*?)", ["Common treatments for {0} include medication, therapy, and lifestyle changes. However, it's best to consult a healthcare professional for personalized treatment advice."]),
    (r"what are the risk factors for (.*?)", ["Risk factors for {0} may include age, gender, family history, lifestyle factors, and certain medical conditions. However, it's best to consult a healthcare professional for personalized advice."]),
    (r"what are some preventative measures for (.*?)", ["Preventative measures for {0} may include maintaining a healthy lifestyle, getting vaccinated, and avoiding exposure to certain substances or environments. However, it's best to consult a healthcare professional for personalized advice."]),
    (r"quit", ["Goodbye!"]),
    (r"(.*)", ["I'm sorry, I don't understand. Can you please rephrase your question?"])
]


# Create the chatbot using the patterns and reflections
chatbot = Chat(patterns, reflections)

# Start the chatbot
chatbot.converse()
