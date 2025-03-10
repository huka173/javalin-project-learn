@import com.example.routes.NamedRoutes

@template.index(
    content = @`
        <div class="container d-flex justify-content-center align-items-center mt-5">
            <form action="${NamedRoutes.sessionsPath()}" method="post">
                <div class="form-group pb-3">
                    <label for="nickname">Name</label>
                    <input type="text" id="nickname" name="nickname" />
                </div>
                <div class="form-group pb-3">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" />
                </div>
                    <input type="submit" placeholder="register"/>
            </form>
        </div>
    `
)