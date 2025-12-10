## AssignmentApplication (Android)

Android app built with Gradle and Java 11 targeting SDK 35 (min SDK 30). Uses SQLite (via `DatabaseHelper`) to manage instructors, students, modules, and tasks with separate dashboards for admin, instructor, and student flows.

### Project structure
- `app/src/main/java/com/example/assignmentapplication/` — activities, adapters, DB helper
- `app/src/main/res/` — layouts, drawables, strings, themes
- `gradlew`, `gradlew.bat` — Gradle wrappers (no global install needed)
- Note: `app/Task.java` and `app/TaskAdapter.java` at the module root look like older copies; the active sources live under `app/src/main/java/...`.

### Prerequisites
- Android Studio Hedgehog or newer
- JDK 11 (Gradle config uses Java 11 compatibility)
- Android SDK 35 (installed via Android Studio SDK Manager)

### How to run (Android Studio)
1. Open Android Studio → **Open** → select this folder (`AssignmentApplication`).
2. Let Gradle sync.
3. Run on an emulator or device (min SDK 30).

### How to build (CLI)
From this directory:
```bash
./gradlew assembleDebug      # macOS/Linux
gradlew.bat assembleDebug    # Windows
```
The APK will be under `app/build/outputs/apk/debug/`.

### Tests
```bash
./gradlew test               # unit tests
./gradlew connectedAndroidTest  # instrumentation (requires device/emulator)
```

### Notes
- Local data is stored via SQLite; no network/backend required.
- If you edit Java/Gradle, keep `sourceCompatibility/targetCompatibility` at 11 unless you also update toolchains.

