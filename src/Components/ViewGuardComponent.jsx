import React, { Component } from "react";
import GuardShiftService from "../service/GuardShiftService";

class ViewGuardComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      userId: this.props.match.params.userId,
      guardShift: {},
    };
  }

  componentDidMount() {
    GuardShiftService.getGuardShiftByUserId(this.state.userId).then(
      (res) => {
        this.setState({ guardShift: res.data });
      }
    );
  }
  render() {
    return (
      <div>
        <br></br>
        <div className="card col-md-6 offset-md-3">
          <h3 className="text-center"> View Guard Shift Details</h3>
          <div className="card-body">
            <div className="row">
              <label> Guard Name: </label>
              <div> {this.state.guardShift.name}</div>
            </div>
            <div className="row">
              <label> Guard Time: </label>
              <div> {this.state.guardShift.time}</div>
            </div>
            <div className="row">
              <label> Date: </label>
              <div> {this.state.guardShift.date}</div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ViewGuardComponent;
