ComposeApp - Product Listing & Details

A modern Android application built using Jetpack Compose, MVVM architecture, and an Offline-First approach.


Summary 

This application fetches product data from the DummyJSON API, providing a listing and detailed view. It is designed to demonstrate modern Android development best practices including Clean Architecture and Offline-First capability.
Architecture (MVVM)

The project follows a structured MVVM pattern:

•
Data Layer: Manages API (Retrofit) and Local Database (Room) operations.

•
Repository Layer: Acts as the Single Source of Truth. It provides data from the local DB and synchronizes it with the remote API.

•
UI Layer: Contains fully declarative UI components built with Jetpack Compose and their respective ViewModels.

•
DI (Dependency Injection): Powered by Hilt for efficient dependency management.
Tech Stack & Libraries

•
Jetpack Compose: Modern toolkit for building native UI.

•
Navigation Compose: For seamless screen transitions.

•
Hilt: Standard library for Dependency Injection on Android.

•
Retrofit & Gson: Type-safe HTTP client for Android and JSON parsing.

•
Room: Persistence library for offline-first data caching.

•
Coroutines & Flow: Reactive programming and asynchronous task handling.

📂 Project Structure

com.example.composeapp

├── data

│   ├── local      # Room DB, DAOs, TypeConverters

│   ├── remote     # Retrofit ApiService

│   ├── models     # Data entities (DTOs & Entities)

│   └── repository # Repository implementations

├── di             # Hilt Modules (Network & Database)

├── ui

│   ├── products   # Product List Screen & ViewModel

│   ├── detail     # Product Detail Screen & ViewModel

│   ├── components # Reusable UI Components (TopAppBar etc.)

│   └── theme      # Compose Theme definitions

└── utils          # Constants and Helper classes


<p align="center">
  <img src="https://github.com/user-attachments/assets/1d1d7416-7d4b-490f-8fa0-dd4233f5e8de" width="300" title="Product List">
  <img src="https://github.com/user-attachments/assets/ec77ed66-1c53-4242-9246-5673d5fde241" width="300" title="Product Detail">
</p>

🚀 How to Run?

1. Clone the repository.

2. Open with Android Studio.

3. Sync Gradle and run the app.

