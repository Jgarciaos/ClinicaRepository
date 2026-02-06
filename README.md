# ClinicaRepository
Application deploy with file management and complete CRUD operations for both patients and employees.

# Overview:
The application is a hospital care management system that allows you to manage basic information related to patients and hospital staff. It works entirely through the console, using interactive menus, and allows you to perform create, read, update, and delete (CRUD) operations.

# Main features:
The application manages two main entities:
Patients: The system allows you to manage patients with the following information:
-    Unique identifier (ID)
-    Name
-    Age
-    Gender
-    Document
-    Document type
-    Triage
-    Admission date
-    Diagnosis
Each patient has an associated diagnosis, although there is no detailed medical history.
Staff: The system also allows hospital staff information to be managed with the following attributes:
- Unique identifier (ID)
- Name
- Document
- Gender
- Profession (Doctor or nurse)

# Use of the application:
The application is used via console menus, where the user selects numerical options to execute the various actions available.
There is no mandatory flow of use, although some actions require logical preliminary steps. For example:
- To delete or update a patient, they must have been previously registered.
- To consult a patient or employee, the corresponding record must exist.
The system displays clear messages and visible options on the screen to the user.

# Data storage:
System data is stored in separate CSV files for each type of person (Patient or Staff). This allows the information to persist between program runs.
The system automatically reads and writes to these files when performing creation, update, or deletion operations.

# Validations and error handling:
The application features:
- Validation of entered data.
- Exception handling, displaying specific error messages when a problem occurs, such as invalid data or unauthorized actions.
This helps prevent errors during system use and improves the user experience.
