package future.skill.problems;

public class LineBreaks {
    /**
     * Take the input 'text' parameter and break it into lines so that it
     * has at most 'width' characters in a single line, and for each line you
     * should come as close to the input parameter 'width' as possible. You
     * may only break the input string 'text' where there is a space, and to
     * break a line, you should replace this space with a '\n' character in
     * the return string.
     */
    public String level1BreakIntoLines(String text, int width) {
        // Write your code here

        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();
        int currentWidth = 0;
        for (String word : words) {
            if (currentWidth + word.length() + 1 <= width) {
                if (currentWidth > 0) {
                    result.append(" ");
                    currentWidth++;
                }
                result.append(word);
                currentWidth += word.length();
            } else {
                if (currentWidth > 0) {
                    result.append("\n");
                }
                result.append(word);
                currentWidth = word.length();
            }
        }

        return result.toString();
    }

    /**
     * You are given an input string 'text' which contains words separated by
     * spaces. Your program should break the text at the optimal location, so
     * that the resulting number of lines (as specified by the input
     * parameter 'num lines') have the minimum possible length in the longest
     * line.
     */
    public String level2BreakIntoLines(String text, int numLines) {
        // Write your code here

        String[] words = text.split(" ");
        int width = text.length() / numLines + (text.length() % numLines > 0 ? 1 : 0);

        StringBuilder temp = new StringBuilder();
        while (temp.length() < text.length()) {
            int currentWidth = 0;
            int currentLine = 0;

            for (String word : words) {
                if (currentWidth + word.length() + 1 <= width) {
                    if (currentWidth > 0) {
                        temp.append(" ");
                        currentWidth++;
                    }
                    temp.append(word);
                    currentWidth += word.length();
                } else {
                    if (currentWidth > 0) {
                        temp.append("\n");
                        currentLine++;
                    }
                    int remainChars = text.length() - temp.length();
                    int neededLines = remainChars / width + (remainChars % width > 0 ? 1 : 0);
                    if (currentLine + neededLines > numLines) {
                        break;
                    }
                    temp.append(word);
                    currentWidth = word.length();
                }
            }
        }

        return temp.toString();
    }
}
