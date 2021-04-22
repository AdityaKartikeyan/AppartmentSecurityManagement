import "./App.css";
import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import ListDeliveryComponent from "./components/ListDeliveryComponent";
import CreateDeliveryComponent from "./components/CreateDeliveryComponent";
import UpdateDeliveryComponent from "./components/UpdateDeliveryComponent";
import ViewDeliveryComponent from "./components/ViewDeliveryComponent";

function App() {
  return (


    <div className="App">
      <Router>
        <HeaderComponent />
        <div className="container">
          <Switch>
            <Route path="/" exact component={ListDeliveryComponent}></Route>
            <Route path="/getAll" component={ListDeliveryComponent}></Route>
            <Route path="/addDelivery" component={CreateDeliveryComponent}></Route>
            <Route path="/updateDelivery/:deliveryId" component={UpdateDeliveryComponent}></Route>
            <Route path="/getByPk/:deliveryId" component={ViewDeliveryComponent}></Route>
          </Switch>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
