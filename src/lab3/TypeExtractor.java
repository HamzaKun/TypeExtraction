package lab3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Skeleton code for a type extractor.
 */
public class TypeExtractor {

    /**
    Given as argument a Wikipedia file, the task is to run through all Wikipedia articles,
    and to extract for each article the type (=class) of which the article
    entity is an instance. For example, from a page starting with "Leicester is a city",
    you should extract "city". 
    
    - extract just the head noun ("American rock star" -> "star")
    - if the type cannot reasonably be extracted ("Mathematics was invented in the 19th century"),
      skip the article (do not output anything)
    - take only the first item of a conjunction ("and")
    - do not extract too general words ("type of", "way", "form of")
    - keep the plural
    
    The output shall be printed to file "result.tsv" in the form
       entity TAB type NEWLINE
    with one or zero lines per entity.    
     */
    public static void main(String args[]) throws IOException {
        try (Writer out = new OutputStreamWriter(new FileOutputStream("results.tsv"), "UTF-8")) {
            try (Parser parser = new Parser(new File(args[0]))) {
                while (parser.hasNext()) {
                    Page nextPage = parser.next();
                    String type = null;
                    // Magic happens here
                    if (type != null) out.write(nextPage.title + "\t" + type + "\n");
                }
            }
        }
    }

}