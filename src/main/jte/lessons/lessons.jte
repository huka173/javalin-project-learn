@import com.example.dto.lessons.LessonsPage
@param LessonsPage page

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
<div class="container">
    <div class="row text-center mt-5">
        <h1>Lessons</h1>
    </div>
    @if(page.getArrLessons().isEmpty())
        <div class="row text-center">
            <h2>lessons empty</h2>
        </div>
    @else
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th>Name lesson</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
            @for(var lesson : page.getArrLessons())
                <tr>
                    <th scope="row"><a href="/lessons/${lesson.getId()}">${lesson.getId()}</a></th>
                    <td>${lesson.getNameLesson()}</td>
                    <td>${lesson.getDescription()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    @endif
</div>
</body>
</html>