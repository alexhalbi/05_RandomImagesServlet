import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateImage")
public class CreateImage extends HttpServlet {
	private static final long serialVersionUID = -5748047638898123700L;

	public CreateImage() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		try {
			BufferedImage bufferedImage = new BufferedImage(400, 400,
					BufferedImage.TYPE_INT_RGB);
			int random;
			random = (int) (Math.random() * 6 + 1);
			Color col = new Color((int) (Math.random() * 255 + 1),
					(int) (Math.random() * 255 + 1),
					(int) (Math.random() * 255 + 1));
			Graphics graph = bufferedImage.getGraphics();

			switch (random) {
			case 1:
				graph.setColor(col);
				graph.fillOval(0, 0, 400, 400);
				break;
			case 2:
				graph.setColor(col);
				graph.fillArc(0, 0, 400, 400, (int) (Math.random() * 180 + 1),
						(int) (Math.random() * 180 + 181));
				break;
			case 3:
				graph.setColor(col);
				graph.drawRoundRect(0, 0, 400, 400, 10, 10);
				break;
			case 4:
				graph.setColor(col);
				graph.drawString("I'm a String", 20, 20);
				break;
			case 5:
				graph.setColor(col);
				graph.fillRect(0, 0, 400, 400);
				break;
			case 6:
				graph.setColor(col);
				graph.drawLine(0, 0, 400, 400);
				break;
			}
			graph.dispose();

			ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
		} catch (IOException ioe) {

		}
	}

}