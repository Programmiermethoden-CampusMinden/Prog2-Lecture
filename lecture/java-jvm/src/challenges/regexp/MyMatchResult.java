package challenges.regexp;

import java.util.regex.MatchResult;

public final class MyMatchResult {
    public final Token token;
    public final MatchResult result;

    public MyMatchResult(Token token, MatchResult result) {
        this.token = token;
        this.result = result;
    }

    public int start() {
        return result.start(token.matchingGroup);
    }

    public int end() {
        return result.end(token.matchingGroup);
    }

    public String group() {
        return result.group(token.matchingGroup);
    }
}
