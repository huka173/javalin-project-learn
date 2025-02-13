@import com.example.dto.students.BuildStudentPage
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
        <form action="/students" method="post">
            <div class="form-group py-3">
                <label for="inputFirstName" class="form-label">First name</label>
                <input type="text" class="form-control" id="inputFirstName" name="firstName" placeholder="Enter first name" required>
            </div>
            <div class="form-group py-3">
                <label for="inputLastName" class="form-label">Last name</label>
                <input type="text" class="form-control" id="inputLastName" name="lastName" placeholder="Enter last name" required>
            </div>
            <div class="form-group py-3">
                <label for="inputEmail" class="form-label">Email address</label>
                <input type="email" class="form-control" id="inputEmail" name="email" placeholder="name@example.com" required>
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    `
)