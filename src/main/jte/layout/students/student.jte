@import com.example.dto.students.StudentPage
@param StudentPage page

@template.index(
    content = @`
        <h1 class="text-center p-5">Student: ${page.getStudent().getId()}</h1>
        <span class="text-center">First name: ${page.getStudent().getFirstName()}</span>
        <span class="text-center">Last name: ${page.getStudent().getLastName()}</span>
        <span class="text-center">Email: ${page.getStudent().getEmail()}</span>
    `
)