@import com.example.dto.students.BuildStudentPage
@import com.example.routes.NamedRoutes

@param BuildStudentPage page

@template.index(
    content = @`
        @if(page.getErrors() != null)
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var elem : validator)
                        <li class="text-danger">${elem.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        @endif
        <form action="${NamedRoutes.studentsPath()}" method="post">
            <div class="form-group py-3">
                <label for="inputFirstName" class="form-label">First name</label>
                <input type="text" class="form-control" id="inputFirstName" name="firstName" placeholder="Enter first name" value="${page.getFirstName()}" required>
            </div>
            <div class="form-group py-3">
                <label for="inputLastName" class="form-label">Last name</label>
                <input type="text" class="form-control" id="inputLastName" name="lastName" placeholder="Enter last name" value="${page.getLastName()}" required>
            </div>
            <div class="form-group py-3">
                <label for="inputEmail" class="form-label">Email address</label>
                <input type="email" class="form-control" id="inputEmail" name="email" placeholder="name@example.com" value="${page.getEmail()}" required>
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    `
)