@template.index(
    content = @`
        <form action="/lessons" method="post">
            <div class="form-group py-3">
                <label for="inputName" class="form-label">Name lesson</label>
                <input type="text" class="form-control" id="inputName" name="nameLesson" placeholder="Enter name lesson" required>
            </div>
            <div class="form-group py-3">
                <label for="inputDescription" class="form-label">Description</label>
                <textarea class="form-control" id="inputDescription" name="description" rows="3"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    `
)