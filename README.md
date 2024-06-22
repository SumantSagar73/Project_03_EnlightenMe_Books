
# EnlightenMeBooks

EnlightenMeBooks is an Android application built using Jetpack Compose. It provides a summary of a book, including the title, author, cover image, and a brief synopsis. Additionally, it displays a scrollable list of book items.

## Features

- Display a list of books with their cover images, titles, and authors.
- Display a detailed summary of a selected book.
- Implemented using Jetpack Compose and Material3 for a modern, declarative UI.

## Screenshots
![Screenshot_20240622_175253](https://github.com/SumantSagar73/Project_03_EnlightenMe_Books/assets/67573044/166f676b-1d50-474c-a587-5abd71bba3bc)
![Screenshot_20240622_175313](https://github.com/SumantSagar73/Project_03_EnlightenMe_Books/assets/67573044/e5bb7450-9896-470c-b745-b583d8011434)
![Screenshot_20240622_175357](https://github.com/SumantSagar73/Project_03_EnlightenMe_Books/assets/67573044/010e428b-dfce-44c2-98f5-0d34823e7e8d)
![Screenshot_20240622_175409](https://github.com/SumantSagar73/Project_03_EnlightenMe_Books/assets/67573044/e7dcdfee-77aa-49d2-aa10-5ee3488f5e40)



## Getting Started

### Prerequisites

- Android Studio
- Knowledge of Kotlin and Jetpack Compose

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/SumantSagar73/Project_03_EnlightenMe_Books.git
   ```

2. Open the project in Android Studio.

3. Make sure you have the required dependencies in your `build.gradle` file:

   ```gradle
   dependencies {
       implementation 'androidx.core:core-ktx:1.8.0'
       implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.5.1'
       implementation 'androidx.activity:activity-compose:1.5.1'
       implementation 'androidx.compose.ui:ui:1.2.1'
       implementation 'androidx.compose.ui:ui-tooling-preview:1.2.1'
       implementation 'androidx.compose.material3:material3:1.0.0-alpha01'
       debugImplementation 'androidx.compose.ui:ui-tooling:1.2.1'
   }
   ```

4. Add the placeholder image `book_cover.png` to the `res/drawable` directory.

5. Run the app on an emulator or a physical device.

### Usage

The app displays a scrollable list of book items at the top. Below the list, it shows a summary of a selected book, including its cover image, title, author, and synopsis.

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/enlightenmebooks/
│   │   │   ├── MainActivity.kt
│   │   │   ├── Book.kt
│   │   │   ├── SampleData.kt
│   │   ├── res/
│   │   │   ├── drawable/
│   │   │   │   ├── book_cover.png
│   │   ├── ui/
│   │   │   ├── theme/
│   │   │   │   ├── Color.kt
│   │   │   │   ├── Theme.kt
│   │   │   │   ├── Type.kt
```

### Main Components

- `MainActivity.kt`: The main activity that sets the content using Jetpack Compose.
- `Book.kt`: Data class representing a book.
- `DataSource.kt`: Contains a function to generate sample book data.
- `Theme.kt`: Defines the theme for the application.

## Contributing

Contributions are welcome! Please fork the repository and submit pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or suggestions, feel free to reach out at 6073sumant@gmail.com.

---

