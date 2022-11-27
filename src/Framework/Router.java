package Framework;

import java.util.HashMap;

public class Router {

    private HashMap<String, ControllerAction> routingTable;
    private HashMap<String, String> helpTable;

    private static Router instance;

    private Router() {
        routingTable = new HashMap<String, ControllerAction>();
        helpTable = new HashMap<String, String>();

    }

    public static Router Instance() {
        if (instance == null)
            instance = new Router();
        return instance;
    }

    public String GetRoutes() {
        StringBuilder sb = new StringBuilder();
        for (var k : routingTable.keySet()) {
            sb.append(String.format("{%s}", k));
        }
        return sb.toString();
    }

    public String GetHelp(String key) {
        if (helpTable.containsKey(key))
            return helpTable.get(key);
        return "Documentation not ready yet!";
    }

    public void Register(String route, ControllerAction action, String help) {
        route = route.trim().toLowerCase();
        if (!routingTable.containsKey(route)) {
            routingTable.put(route, action);
            helpTable.put(route, help);
        }
    }

    public void Forward(String request) throws Exception {
        var req = new Request(request);
        if (!routingTable.containsKey(req.route)) {
            throw new Exception("Command not found!");
        }
        if (req.parameter == null) {
            routingTable.get(req.route).action(null);
        } else {
            routingTable.get(req.route).action(req.parameter);
        }
    }

    public void ClearAll() {
        routingTable.clear();
    }

    private class Request {

        public String route;

        public String getRoute() {
            return route;
        }

        public void setRoute(String route) {
            route = route;
        }

        public Parameter parameter;

        public Parameter getParameter() {
            return parameter;
        }

        private void setParameter(Parameter parameter) {
            this.parameter = parameter;
        }

        public Request(String request) throws Exception {
            Analyze(request);
        }

        private void Analyze(String request) throws Exception {
            var firstIndex = request.indexOf('?');
            // trường hợp truy vấn không chứa tham số
            if (firstIndex < 0) {
                route = request.toLowerCase().trim();
            } else {
                // neu chuoi loi chua tham so ko chua phan route
                if (firstIndex <= 1)
                    throw new Exception("Invalid request parameter");
                var token = request.split("?");
                route = token[0].trim().toLowerCase();
                var parameterPart = request.substring(firstIndex + 1).trim();
                parameter = new Parameter(parameterPart);
            }
        }
    }

}
