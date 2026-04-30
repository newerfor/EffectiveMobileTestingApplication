[README_Courses.md](https://github.com/user-attachments/files/27238138/README_Courses.md)
<div align="center">

# 📚 Courses

### Платформа для поиска и отслеживания онлайн-курсов

*Мобильное приложение с каталогом курсов, системой избранного*  
*и персональным профилем с прогрессом обучения.*

<br>

![Android](https://img.shields.io/badge/Android-SDK%2034+-3DDC84?style=flat-square&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9+-7F52FF?style=flat-square&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-4285F4?style=flat-square&logo=jetpackcompose&logoColor=white)
![Retrofit](https://img.shields.io/badge/Retrofit-REST%20API-FF6B35?style=flat-square)
![Gradle](https://img.shields.io/badge/Gradle-8.0+-02303A?style=flat-square&logo=gradle&logoColor=white)

</div>

---

## 📱 Скриншоты

<div align="center">

| Главный экран | Детали курса | Избранное | Профиль |
|:---:|:---:|:---:|:---:|
| <img src="pictures/main.png" width="180"/> | <img src="pictures/course_info.png" width="180"/> | <img src="pictures/favorite.png" width="180"/> | <img src="pictures/account.png" width="180"/> |

</div>

---

## ✨ Возможности

| Экран | Описание |
|-------|----------|
| 🏠 **Главный экран** | Каталог курсов с поиском, сортировкой и фильтрацией |
| 📖 **Детали курса** | Описание, цена, рейтинг, дата начала, автор |
| ❤️ **Избранное** | Сохранённые курсы с быстрым доступом |
| 👤 **Профиль** | Личные данные пользователя и список курсов с прогрессом |
| 🔐 **Авторизация** | Экран входа с вводом данных и кнопками соцсетей |

---

## 🏗 Архитектура

Проект построен на **Clean Architecture** с модульной структурой. Каждый модуль компилируется независимо, что ускоряет инкрементальные сборки и упрощает масштабирование.

```
Courses/
├── app/                              # Entry point, DI, навигация
│
├── core/
│   ├── core-data/                    # Retrofit, Room, Repository impl
│   │   ├── remote/                   # ApiService, ApiClient, RemoteDataSource
│   │   └── local/                    # CoursesDao, CoursesDatabase, LocalDataSource
│   ├── core-domain/                  # Модели, CoursesRepository, Use Cases
│   ├── core-navigation/              # NavRoutes — единые маршруты навигации
│   ├── core-ui/                      # CoursesCard, GlassChip, StateView, тема
│   └── core-viewmodel/               # CoursesViewModel, UserInfoViewModel
│
└── feature/
    ├── feature-main/                 # Каталог + поиск + фильтры
    ├── feature-single-course/        # Детальная страница курса
    ├── feature-favorit-course/       # Экран избранного
    ├── feature-profile/              # Профиль и прогресс пользователя
    └── feature-login/                # Экран авторизации
```

### Ключевые архитектурные решения

- **Single Activity** — вся навигация через Jetpack Compose Navigation, единый lifecycle
- **MVVM + StateFlow** — `CoursesViewModel` и `UserInfoViewModel` управляют состоянием через реактивные потоки
- **Repository Pattern** — `RemoteDataSource` и `LocalDataSource` за единым `CoursesRepository`
- **Use Cases** — каждая операция инкапсулирована: `GetAllCoursesUseCase`, `GetCoursesByLikeUseCase`, `SaveCoursesUseCase`, `DeleteCourseUseCase` и другие

---

## 🛠 Технологический стек

| Категория | Технология |
|-----------|------------|
| **Язык** | Kotlin 1.9+ |
| **UI** | Jetpack Compose, Material Design 3 |
| **Навигация** | Jetpack Compose Navigation |
| **Сеть** | Retrofit + REST API |
| **База данных** | Room (CoursesDao, миграции) |
| **DI** | Koin |
| **Асинхронность** | Coroutines, StateFlow |

---

## 🚀 Установка и запуск

### Требования

- Android Studio Hedgehog или новее
- Android SDK 34+
- Kotlin 1.9+
- Gradle 8.0+

### Шаги

```bash
# 1. Клонировать репозиторий
git clone https://github.com/your-username/Courses.git

# 2. Открыть в Android Studio
# File → Open → выбрать папку Courses

# 3. Дождаться синхронизации Gradle и запустить
# Run → Run 'app'  (Shift + F10)
```

При первом запуске данные загружаются из REST API и кэшируются локально в Room.

---

## 📬 Контакты

**vladislav.yurshin.work@yandex.ru**
