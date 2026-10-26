ComposeApp - Product Listing & Details

A modern Android application built using Jetpack Compose, MVVM architecture, and an Offline-First approach with WorkManager synchronization.


Summary 

This application fetches product data from the DummyJSON API, providing a listing and detailed view. It is designed to demonstrate modern Android development best practices including Clean Architecture, Offline-First capability, automatic retry policies, and background synchronization using WorkManager.

Architecture (MVVM + Offline-First)

The project follows a structured MVVM pattern and an Offline-First strategy:

• Data Layer: Manages API (Retrofit) and Local Database (Room) operations.
• Repository Layer: Acts as the Single Source of Truth (SSOT). It serves cached data directly from Room and handles remote synchronization.
• Background Sync Katmanı (WorkManager): Schedules one-time and periodic (every 6 hours) background data synchronization with network and battery constraints, as well as exponential backoff retries.
• UI Layer: Contains fully declarative UI components built with Jetpack Compose and ViewModels observing Room Flow streams.
• DI (Dependency Injection): Powered by Hilt (including `@HiltWorker` for WorkManager dependency injection).

Tech Stack & Libraries

• Jetpack Compose: Modern toolkit for building native UI.
• Navigation Compose: For seamless screen transitions.
• Hilt & Hilt Work: Standard library for Dependency Injection and WorkManager injection.
• WorkManager: Background task scheduler for reliable, constraint-based data synchronization.
• Retrofit & Gson: Type-safe HTTP client for Android and JSON parsing.
• Room: Persistence library for offline-first data caching.
• Coroutines & Flow: Reactive programming and asynchronous task handling.

📂 Project Structure

com.example.composeapp

├── data

│   ├── local      # Room DB, DAOs, TypeConverters

│   ├── remote     # Retrofit ApiService & RetryInterceptor

│   ├── models     # Data entities (DTOs & Entities)

│   └── repository # Repository implementations

├── di             # Hilt Modules (Network & Database)

├── ui

│   ├── products   # Product List Screen & ViewModel

│   ├── detail     # Product Detail Screen & ViewModel

│   ├── components # Reusable UI Components (TopAppBar etc.)

│   └── theme      # Compose Theme definitions

├── utils          # Constants and Helper classes (RetryUtils etc.)

└── worker         # WorkManager implementation (SyncProductsWorker, SyncWorkManager)


<p align="center">
  <img src="https://github.com/user-attachments/assets/1d1d7416-7d4b-490f-8fa0-dd4233f5e8de" width="300" title="Product List">
  <img src="https://github.com/user-attachments/assets/ec77ed66-1c53-4242-9246-5673d5fde241" width="300" title="Product Detail">
</p>

🚀 How to Run?

1. Clone the repository.
2. 
3. Open with Android Studio.
4. 
5. Sync Gradle and run the app.

