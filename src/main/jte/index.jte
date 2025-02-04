@import gg.jte.Content

@param Content content = null

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>javalin-project-learn</title>
</head>
<body>
    <div class="container">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <h1 class="fs-4">Javalin-project-learn</h1>
            </a>
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="/" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="/lessons" class="nav-link">Lessons</a></li>
                <li class="nav-item"><a href="/students" class="nav-link">Students</a></li>
            </ul>
        </header>
        <div class="row m-5">
            @if(content != null)
                ${content}
            @else
                <h1 class="text-center">This is test project for learn Javalin and JTE</h1>
            @endif
        </div>
        <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
            <p class="col-md-4 mb-0 text-muted">Coder: Huka</p>
            <a class="d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto text-decoration-none text-muted" href="/"><span>javalin-project-learn</span></a>
            <ul class="nav col-md-4 justify-content-end">
                <li class="nav-item"><a href="/" class="nav-link x-2 text-muted">Home</a></li>
                <li class="nav-item"><a href="/lessons" class="nav-link x-2 text-muted">Lessons</a></li>
                <li class="nav-item"><a href="/students" class="nav-link x-2 text-muted">Students</a></li>
                <li class="nav-item">
                    <a href="https://github.com/huka173" class="nav-link x-2 text-muted">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-github" viewBox="0 0 16 16">
                            <path d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27s1.36.09 2 .27c1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.01 8.01 0 0 0 16 8c0-4.42-3.58-8-8-8"/>
                        </svg>
                    </a>
                </li>
            </ul>
        </footer>
    </div>
</body>
</html>