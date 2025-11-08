# TMDB - Top Rated TV Shows Android App

An Android application that displays top-rated TV shows from The Movie Database (TMDB) API using modern Android development practices.

## 📱 Features

- Display top-rated TV shows in a grid layout
- Shows poster images for each TV show
- Visual rating indicators with color-coded circular progress bars:
  - 🟢 Green: Rating > 8
  - 🟡 Yellow: Rating > 5
  - 🔴 Red: Rating ≤ 5
- Display show name and air year
- Responsive grid layout (3 columns)

## 🛠️ Tech Stack & Architecture

### Language & Framework
- **Kotlin** - Primary programming language
- **Jetpack Compose** - Modern declarative UI toolkit

### Architecture & Design Patterns
- **MVVM (Model-View-ViewModel)** - Architecture pattern
- **Dependency Injection** - Dagger Hilt
- **Coroutines** - Asynchronous programming

### Libraries & Dependencies

| Library | Purpose |
|---------|---------|
| Jetpack Compose | Modern UI toolkit |
| Hilt | Dependency injection |
| Retrofit | REST API client |
| Moshi | JSON parsing |
| OkHttp | HTTP client |
| Coil | Image loading and caching |
| Coroutines | Asynchronous operations |
| StateFlow | Reactive state management |

## 📋 Prerequisites

- **Android Studio**: Arctic Fox or newer
- **JDK**: Version 8 or higher
- **Android SDK**: 
  - Minimum SDK: 26 (Android 8.0)
  - Target SDK: 34 (Android 14)
  - Compile SDK: 34

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/DarshReddy/TMDB_Assignment.git
cd TMDB_Assignment
```

### 2. Open in Android Studio

1. Launch Android Studio
2. Select "Open an Existing Project"
3. Navigate to the cloned repository folder
4. Click "OK" and wait for Gradle sync to complete

### 3. Build the Project

```bash
./gradlew build
```

Or use Android Studio's Build menu:
- **Build > Make Project** (Ctrl+F9 / Cmd+F9)

### 4. Run the App

Connect an Android device or start an emulator, then:

```bash
./gradlew installDebug
```

Or click the **Run** button in Android Studio (Shift+F10 / Ctrl+R)

## 📂 Project Structure

```
TMDB_Assignment/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/assignment/tmdb/
│   │   │   │   ├── data/           # Data models
│   │   │   │   │   └── TopRated.kt # Response and result data classes
│   │   │   │   ├── di/             # Dependency injection
│   │   │   │   │   └── AppModule.kt # Hilt module
│   │   │   │   ├── network/        # Network layer
│   │   │   │   │   └── ApiClient.kt # Retrofit API interface
│   │   │   │   ├── ui/theme/       # UI theming
│   │   │   │   │   ├── Color.kt
│   │   │   │   │   ├── Theme.kt
│   │   │   │   │   └── Type.kt
│   │   │   │   ├── MainActivity.kt # Main activity with Compose UI
│   │   │   │   ├── MainViewModel.kt # ViewModel
│   │   │   │   └── TmdbApplication.kt # Application class
│   │   │   ├── res/                # Resources
│   │   │   └── AndroidManifest.xml
│   │   ├── androidTest/            # Instrumented tests
│   │   └── test/                   # Unit tests
│   └── build.gradle.kts            # App-level Gradle configuration
├── gradle/                         # Gradle wrapper
├── build.gradle.kts                # Project-level Gradle configuration
├── settings.gradle.kts             # Gradle settings
└── README.md                       # This file
```

## 🔑 API Configuration

This app uses the TMDB API to fetch top-rated TV shows. The API key is configured in the `AppModule.kt` file using Bearer token authentication.

**Base URL**: `https://api.themoviedb.org/3/`

**Endpoint Used**: `tv/top_rated`

## 🎨 UI Components

### MainActivity
- Entry point of the application
- Hosts the Compose UI with `MoviesGrid` composable

### MoviesGrid Composable
- Displays a lazy vertical grid with 3 columns
- Each item shows:
  - Poster image loaded with Coil
  - Circular progress indicator showing rating
  - Show title
  - First air date (year)

### Color-Coded Rating System
The app uses a visual rating system with colored circular progress indicators:
- **Green** (> 8.0): Excellent shows
- **Yellow** (5.0 - 8.0): Good shows
- **Red** (≤ 5.0): Below average shows

## 🏗️ Build Variants

- **Debug**: Development build with debugging enabled
- **Release**: Production-ready build with ProGuard optimization (when configured)

## 📦 Dependencies Management

This project uses Gradle Version Catalog (`libs.versions.toml`) for centralized dependency management.

## 🧪 Testing

### Run Unit Tests
```bash
./gradlew test
```

### Run Instrumented Tests
```bash
./gradlew connectedAndroidTest
```

## 🔧 Troubleshooting

### Common Issues

1. **Gradle Sync Failed**
   - Ensure you have a stable internet connection
   - Try: File > Invalidate Caches / Restart

2. **Build Errors**
   - Clean the project: `./gradlew clean`
   - Rebuild: `./gradlew build`

3. **API Issues**
   - Verify internet connectivity
   - Check if TMDB API is accessible
   - Ensure the API key is valid

## 📄 License

This project is for educational/assignment purposes.

## 🤝 Contributing

This is an assignment project. For any questions or issues, please contact the repository owner.

## 📞 Contact

- **GitHub**: [@DarshReddy](https://github.com/DarshReddy)

---

**Note**: This app requires an active internet connection to fetch data from TMDB API.
