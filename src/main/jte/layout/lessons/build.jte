@import com.example.dto.lessons.BuildLessonPage
@import com.example.routes.NamedRoutes

@param BuildLessonPage page

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
        <form action="${NamedRoutes.lessonsPath()}" method="post">
            <div class="form-group py-3">
                <label for="inputName" class="form-label">Name lesson</label>
                <input type="text" class="form-control" id="inputName" name="nameLesson" placeholder="Enter name lesson" value="${page.getNameLesson()}" required>
            </div>
            <div class="form-group py-3">
                <label for="inputDescription" class="form-label">Description</label>
                <textarea class="form-control" id="inputDescription" name="description" rows="3" placeholder="Enter description">${page.getDescription()}</textarea>
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    `
)