@import com.example.dto.students.StudentsPage
@import com.example.routes.NamedRoutes
@param StudentsPage page

@template.index(
    search = @`
        <li class="nav-item p-1">
            <form action="${NamedRoutes.studentsPath()}" method="get">
                <label for="search">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                    </svg>
                </label>
                <input type="search" id="search" name="search" value="${page.getSearch()}">
            </form>
        </li>
    `,
    content = @`
        <h1 class="text-center p-5">Students</h1>
        @if(page.getFlash() != null)
            <p class="p-0 text-success">${page.getFlash()}</p>
        @endif
        <div class="col-2 mb-5 mt-2 p-0">
            <a href="${NamedRoutes.studentsBuildPath()}" type="button" class="btn btn-primary">Add</a>
        </div>
        <table class="table mb-5">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            @for(var elem : page.getStudents())
                <tr>
                    <th scope="row"><a href="${NamedRoutes.studentPath(elem.getId())}">${elem.getId()}</a></th>
                    <td>${elem.getFirstName()}</td>
                    <td>${elem.getLastName()}</td>
                    <td>${elem.getEmail()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    `
)
