package com.url.downloadProject;

import java.io.IOException;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.first.app.ModelData;

/**
 * Servlet implementation class FetchingDetailsServlet
 */
@WebServlet("/FetchingDetailsServlet")
public class FetchingDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> fileNames = new ArrayList<String>();
		// UK files
		fileNames.add("Tmax/date/UK.txt");
		fileNames.add("Tmin/date/UK.txt");
		fileNames.add("Tmean/date/UK.txt");
		fileNames.add("Sunshine/date/UK.txt");
		fileNames.add("Rainfall/date/UK.txt");
		// England files
		fileNames.add("Tmax/date/England.txt");
		fileNames.add("Tmin/date/England.txt");
		fileNames.add("Tmean/date/England.txt");
		fileNames.add("Sunshine/date/England.txt");
		fileNames.add("Rainfall/date/England.txt");
		// Wales files
		fileNames.add("Tmax/date/Wales.txt");
		fileNames.add("Tmin/date/Wales.txt");
		fileNames.add("Tmean/date/Wales.txt");
		fileNames.add("Sunshine/date/Wales.txt");
		fileNames.add("Rainfall/date/Wales.txt");
		// Scotland files
		fileNames.add("Tmax/date/Scotland.txt");
		fileNames.add("Tmin/date/Scotland.txt");
		fileNames.add("Tmean/date/Scotland.txt");
		fileNames.add("Sunshine/date/Scotland.txt");
		fileNames.add("Rainfall/date/Scotland.txt");

		// URL pointing to the file

		ArrayList<ArrayList<ModelData>> k = DataManager.copyURLToFile(fileNames);

		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=\"weather.csv\"");
		// adding data into .csv file
		OutputStream outputStream = response.getOutputStream();
		StringBuffer k1 = new StringBuffer(" Region,WeatherParam,Year,Month,Value");
		k1.append("\n");
		if (k != null && k.size() > 0) {
			for (int j = 0; j < k.size(); j++) {
				for (int j1 = 0; j1 < k.get(j).size(); j1++) {
						
					int count = 0;
					for (; count < 17; count++) {
						k1.append(k.get(j).get(j1).getCountry() == null ? "," + " " : k.get(j).get(j1).getCountry());
						k1.append(k.get(j).get(j1).getWeatherParam() == null ? "," + " "
								: "," + k.get(j).get(j1).getWeatherParam());
						k1.append(k.get(j).get(j1).getYear() == null ? "," + " " : "," + k.get(j).get(j1).getYear());

						if (count == 0) {
							k1.append(k.get(j).get(j1).getJan() == null || "---".equals(k.get(j).get(j1).getJan())
									? "," + "Jan" + "," + "N/A"
									: "," + "Jan" + "," + k.get(j).get(j1).getJan());
						} else if (count == 1) {
							k1.append(k.get(j).get(j1).getFeb() == null || "---".equals(k.get(j).get(j1).getFeb())
									? "," + "Feb" + "," + "N/A"
									: "," + "Feb" + "," + k.get(j).get(j1).getFeb());
						} else if (count == 2) {
							k1.append(k.get(j).get(j1).getMar() == null || "---".equals(k.get(j).get(j1).getMar())
									? "," + "Mar" + "," + "N/A"
									: "," + "Mar" + "," + k.get(j).get(j1).getMar());
						} else if (count == 3) {
							k1.append(k.get(j).get(j1).getApr() == null || "---".equals(k.get(j).get(j1).getApr())
									? "," + "APR" + "," + "N/A"
									: "," + "APR" + "," + k.get(j).get(j1).getApr());
						} else if (count == 4) {
							k1.append(k.get(j).get(j1).getMay() == null || "---".equals(k.get(j).get(j1).getMay())
									? "," + "MAY" + "," + "N/A"
									: "," + "MAY" + "," + k.get(j).get(j1).getMay());
						} else if (count == 5) {
							k1.append(k.get(j).get(j1).getJune() == null || "---".equals(k.get(j).get(j1).getJune())
									? "," + "JUNE" + "," + "N/A"
									: "," + "JUNE" + "," + k.get(j).get(j1).getJune());
						} else if (count == 6) {
							k1.append(k.get(j).get(j1).getJuly() == null || "---".equals(k.get(j).get(j1).getJuly())
									? "," + "JULY" + "," + "N/A"
									: "," + "JULY" + "," + k.get(j).get(j1).getJuly());
						} else if (count == 7) {
							k1.append(k.get(j).get(j1).getAug() == null || "---".equals(k.get(j).get(j1).getAug())
									? "," + "AUG" + "," + "N/A"
									: "," + "AUG" + "," + k.get(j).get(j1).getAug());
						} else if (count == 8) {
							k1.append(k.get(j).get(j1).getSep() == null || "---".equals(k.get(j).get(j1).getSep())
									? "," + "SEP" + "," + "N/A"
									: "," + "SEP" + "," + k.get(j).get(j1).getSep());
						} else if (count == 9) {
							k1.append(k.get(j).get(j1).getOct() == null || "---".equals(k.get(j).get(j1).getOct())
									? "," + "OCT" + "," + "N/A"
									: "," + "OCT" + "," + k.get(j).get(j1).getOct());
						} else if (count == 10) {
							k1.append(k.get(j).get(j1).getNov() == null || "---".equals(k.get(j).get(j1).getNov())
									? "," + "NOV" + "," + "N/A"
									: "," + "NOV" + "," + k.get(j).get(j1).getNov());
						} else if (count == 11) {
							k1.append(k.get(j).get(j1).getDec() == null || "---".equals(k.get(j).get(j1).getDec())
									? "," + "DEC" + "," + "N/A"
									: "," + "DEC" + "," + k.get(j).get(j1).getDec());
						} else if (count == 12) {
							k1.append(k.get(j).get(j1).getWin() == null || "---".equals(k.get(j).get(j1).getWin())
									? "," + "WIN" + "," + "N/A"
									: "," + "WIN" + "," + k.get(j).get(j1).getWin());
						} else if (count == 13) {
							k1.append(k.get(j).get(j1).getSpr() == null || "---".equals(k.get(j).get(j1).getSpr())
									? "," + "SPR" + "," + "N/A"
									: "," + "SPR" + "," + k.get(j).get(j1).getSpr());
						} else if (count == 14) {
							k1.append(k.get(j).get(j1).getSum() == null || "---".equals(k.get(j).get(j1).getSum())
									? "," + "SUM" + "," + "N/A"
									: "," + "SUM" + "," + k.get(j).get(j1).getSum());
						} else if (count == 15) {
							k1.append(k.get(j).get(j1).getAut() == null ? "," + "AUTM" + "," + "N/A "
									: "," + "AUTM" + "," + k.get(j).get(j1).getAut());
						} else if (count == 16) {
							k1.append(k.get(j).get(j1).getAnn() == null ? "," + "ANN" + "," + "N/A "
									: "," + "ANN" + "," + k.get(j).get(j1).getAnn());
						}

						k1.append("," + " ");
						k1.append("\n");
					}
				}
			}
			outputStream.write(k1.toString().getBytes());
			outputStream.flush();
			outputStream.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
