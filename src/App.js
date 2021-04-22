import "./App.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import ListGuardTrainingComponent from "./components/ListGuardTrainingComponent";
import CreateGuardTrainingComponent from "./components/CreateGuardTrainingComponent";
import UpdateGuardTrainingComponent from "./components/UpdateGuardTrainingComponent";
import ViewGuardComponent from "./components/ViewGuardComponent";

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Switch>
            <Route
              path="/"
              exact
              component={ListGuardTrainingComponent}
            ></Route>
            <Route
              path="/guardTraining"
              component={ListGuardTrainingComponent}
            ></Route>
            <Route
              path="/add-guardTraining"
              component={CreateGuardTrainingComponent}
            ></Route>
            <Route
              path="/update-guardTraining/:userId"
              component={UpdateGuardTrainingComponent}
            ></Route>
            <Route
              path="/getById/:userId"
              component={ViewGuardComponent}
            ></Route>
          </Switch>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
