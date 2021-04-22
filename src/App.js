
import './App.css';

import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListGuardSalaryComponent from './components/ListGuardSalaryComponent'
import CreateGuardSalaryComponent from './components/CreateGuardSalaryComponent'
import UpdateGuardSalaryComponent from './components/UpdateGuardSalaryComponent'
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import ViewGuardSalaryComponent from './components/ViewGuardSalaryComponent';

function App() {
  return (
    <div>
      <Router>
        
            <HeaderComponent />
            <div className="container">
              <Switch> 
                <Route path = "/" exact component= {ListGuardSalaryComponent}></Route>
                <Route path = "/GuardSalary" component= {ListGuardSalaryComponent}></Route>
                <Route path = "/add-GuardSalary" component= {CreateGuardSalaryComponent}></Route>
                <Route path = "/update-GuardSalary/:userId" component= {UpdateGuardSalaryComponent}></Route>
                <Route path = "/getById/:userId" component={ViewGuardSalaryComponent}></Route>
              </Switch>
            </div>  
           <FooterComponent />
        
      </Router>
    
    </div>
    
  );
}

export default App;
