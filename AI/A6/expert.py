print("Welcome to the Medical Expert System!")

# Define a function to ask the user about the symptoms and return a list of symptoms
def get_symptoms():
    print("Please enter your symptoms one by one, then enter 'done' when finished.")
    symptoms = []
    while True:
        symptom = input().lower()
        if symptom == 'done':
            break
        symptoms.append(symptom)
    return symptoms


# Define the rules for diagnosis
def diagnose(symptoms):
    if 'fever' in symptoms:
        if 'rash' in symptoms:
            print("You may have measles. The cure for measles is rest, fluids, and fever-reducing medication.")
        else:
            print("You may have a common cold. The cure for a common cold is rest, fluids, and over-the-counter medications to relieve symptoms.")
            
    elif 'cough' in symptoms:
        if 'shortness of breath' in symptoms:
            print("You may have pneumonia. The cure for pneumonia is rest, antibiotics, and medication to relieve symptoms.")
        else:
            print("You may have bronchitis. The cure for bronchitis is rest, fluids, and over-the-counter medications to relieve symptoms.")
            
    elif 'headache' in symptoms:
        if 'nausea' in symptoms or 'vomiting' in symptoms:
            print("You may have a migraine. The cure for a migraine is rest, medications to relieve symptoms, and avoiding triggers.")
        else:
            print("You may have a tension headache. The cure for a tension headache is rest, over-the-counter medications, and stress reduction techniques.")
            
    elif 'chest pain' in symptoms:
        if 'fatigue' in symptoms or 'irregular heartbeat' in symptoms :
            print("You may have a high blood pressure. The cure for high blood pressure is lifestyle changes and medications prescribed by a doctor.")
        else:
            print("You may have a high blood pressure. The cure for high blood pressure is lifestyle changes and medications prescribed by a doctor.")     
            
    elif 'frequent urination' in symptoms:
        if 'blurred vision' in symptoms:
            print("You may have diabetes. The cure for diabetes involves lifestyle changes, medications, and insulin therapy as prescribed by a doctor.")
        else:
            print("You may have diabetes. The cure for diabetes involves lifestyle changes, medications, and insulin therapy as prescribed by a doctor.")    
           
    else:
        print("I'm sorry, I'm not sure what you have. Please consult a doctor.")

# Keep diagnosing the user's symptoms until they're done
while True:
    symptoms = get_symptoms()
    diagnose(symptoms)
    response = input("Do you have any other symptoms? (yes or no) ")
    if response.lower() != 'yes':
        break

print("Thank you for using the Medical Expert System.")