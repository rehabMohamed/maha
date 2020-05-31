# **Gallery**

Gallery is a simplified photo booth application which allows the user to take photos and see previously taken photos.

## Installation:

Clone this repository and import into Android Studio
```bash
git  clone git@github.com:smartcommut/bus-customer.git
```

## Architecture:
The application follows the MVP architecture. It consists of 4 screens. Each screen exists in a separate package under the main package as follows:
- **Main Screen:** An entry of the application that gives the user 2 options; take a photo and view photos.
- **Take photo screen:** It uses the default camera to capture a photo and save it to the internal files directory of the application. After saving the photo, the user has the option to give a name to the photo then it is saved to the local database with the name and creation date.
- **Photos screen:** Access the database to retrieve the list of photos and display them in a list.
- **Photo list screen:** Displays the photo in full screen while keeping the scale ratio of the original photo when the user clicks on any photo in the photo list screen.

## Database:
The app uses [Room](https://developer.android.com/training/data-storage/room) database. It has only one entity (table) called Photo which has 4 fields:
- **id:** the primary key (auto generated)
- **name:** the photo name.
- **url:** the url to the saved photo in the internal files directory
- **createdAt:** the date of creating the photo.

## Dependency injection
[dagger 2](https://github.com/google/dagger) is used to provide the dependencies to the app components.
- **AppModule:** provides the database and the dao
- **PhotoListModule:** provides the presenter and the adapter to the PhotoListActivity
- **TakePhotoModule:** provides the presenter to TakePhotoActivity

## Image loading:
[Glide](https://github.com/bumptech/glide) is used to load the images as it is recommended by google for its memory efficiency. An extension function is created under the utils package to separate the Glide dependency from the screens’ implementation

## Threading:
[rxjava2](https://github.com/ReactiveX/RxJava) is used to access the database, insert and retrieve, in the background. It is compatible with the Room database.

## Testing
There are 2 testing classes under the testing directory:
- **AppDatabaseReadWriteTest:** unit tests the database operations.
- **TakePhotoPresenterImplTest:** tests the behaviour of the TakePhotoPresenter.

## To be improved:
- Cover more testing.
- Test the UI
