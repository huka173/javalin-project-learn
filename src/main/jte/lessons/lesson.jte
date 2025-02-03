@import com.example.dto.lessons.LessonPage
@param LessonPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>javalin-project-learn</title>
</head>
<body>
    <div class="container text-center">
        @if(page != null)
            <div class="row mt-5">
                <h1>Lesson: ${page.getLesson().getNameLesson()}</h1>
            </div>
            <div class="row mt-2">
                <span><h3>description:</h3> ${page.getLesson().getDescription()}</span>
            </div>
        @else
            <h1>Not found lesson</h1>
        @endif
    </div>
</body>
</html>