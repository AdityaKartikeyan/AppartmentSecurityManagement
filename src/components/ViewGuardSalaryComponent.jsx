import React, { Component } from 'react';
import GuardSalaryService from "../services/GuardSalaryService";

class ViewGuardSalaryComponent extends Component {
    
constructor(props) {
    super(props);

    this.state = {
      userId: this.props.match.params.userId,
      guardSalary: {},
    };
  }

  componentDidMount() {
    GuardSalaryService.getGuardSalayById(this.state.userId).then(
      (res) => {
        this.setState({ guardSalary: res.data });
      }
    );
  }
  render() {
    return (
      <div>
        <br></br>
        <div className="card col-md-6 offset-md-3">
          <h3 className="text-center"> View Guard Salary Details</h3>
          <div className="card-body">
            <div className="row">
              <label> Guard Name: </label>
              <div> {this.state.guardSalary.name}</div>
            </div>
            <div className="row">
              <label> Guard Amount: </label>
              <div> {this.state.guardSalary.amount}</div>
            </div>
            <div className="row">
              <label> Guard Status: </label>
              <div> {this.state.guardSalary.status}</div>
            </div>
            <div className="row">
              <label> Date: </label>
              <div> {this.state.guardSalary.date}</div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default ViewGuardSalaryComponent;