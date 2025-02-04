@import com.example.dto.students.StudentsPage
@param StudentsPage page

@template.index(
    content = @`
        <h1 class="text-center p-5">Students</h1>
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
            @for(var elem : page.getArrStudent())
                <tr>
                    <th scope="row"><a href="/students/${elem.getId()}">${elem.getId()}</a></th>
                    <td>${elem.getFirstName()}</td>
                    <td>${elem.getLastName()}</td>
                    <td>${elem.getEmail()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    `
)
