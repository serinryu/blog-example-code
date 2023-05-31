import com.spring.mvc.MVC01.NotebookDTO;
import org.junit.jupiter.api.Test;

public class NotebookDTOTest {
    @Test
    public void notebookDTOTest(){
        NotebookDTO notebook = new NotebookDTO();
        notebook.getName(); // NotebookDTO 클래스에 붙은 롬복 애노테이션 @Data 에 의해 getter 자동생성됨 확인
    }
}