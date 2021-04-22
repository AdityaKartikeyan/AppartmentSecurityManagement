import React, { Component } from "react";
import GuardTrainingService from "../services/GuardTrainingService";
let today = new Date();
class UpdateGuardTrainingComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      userId: this.props.match.params.userId,
      id: "",
      name: "",
      mobileNo: "",
      status: "",
      timing: "",
    };

    this.changeIdHandler = this.changeIdHandler.bind(this);
    this.changeNameHandler = this.changeNameHandler.bind(this);
    this.changeMobileNoHandler = this.changeMobileNoHandler.bind(this);
    this.changeStatusHandler = this.changeStatusHandler.bind(this);
    this.changeTimingHandler = this.changeTimingHandler.bind(this);

    this.updateGuardTraining = this.updateGuardTraining.bind(this);
  }

  componentDidMount() {
    GuardTrainingService.getGuardTrainingByUserId(this.state.userId).then(
      (res) => {
        let guards = res.data;
        this.setState({
          id: guards.id,
          name: guards.name,
          mobileNo: guards.mobileNo,
          status: guards.status,
          timing: guards.timing,
        });
      }
    );
  }

  updateGuardTraining = (e) => {
    e.preventDefault();
    let guards = {
      id: this.state.id,
      name: this.state.name,
      mobileNo: this.state.mobileNo,
      status: this.state.status,
      timing: this.state.timing,
      date: today,
    };
    console.log("guards => " + JSON.stringify(guards));

    GuardTrainingService.updateGuardTraining(guards, this.state.userId).then(
      (res) => {
        this.props.history.push("");
      }
    );
  };

  changeIdHandler = (event) => {
    this.setState({ id: event.target.value });
  };

  changeNameHandler = (event) => {
    this.setState({ name: event.target.value });
  };
  changeMobileNoHandler = (event) => {
    this.setState({ mobileNo: event.target.value });
  };
  changeStatusHandler = (event) => {
    this.setState({ status: event.target.value });
  };

  changeTimingHandler = (event) => {
    this.setState({ timing: event.target.value });
  };

  changeDateHandler = (event) => {
    this.setState({ today: event.target.value });
  };

  cancel() {
    this.props.history.push("/guardTraining");
  }
  render() {
    return (
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h3 className="text-center">Update Guard Training</h3>
            <div className="card-body">
              <form>
                <div className="form-group">
                  <label>Id</label>
                  <input
                    placeholder="id"
                    name="id"
                    className="form-control"
                    value={this.state.id}
                    onChange={this.changeIdHandler}
                  />
                </div>
                <div className="form-group">
                  <label>Name</label>
                  <input
                    placeholder="Name"
                    name="name"
                    className="form-control"
                    value={this.state.name}
                    onChange={this.changeNameHandler}
                  />
                </div>
                <div className="form-group">
                  <label>Mobile No</label>
                  <input
                    placeholder="Mobile No"
                    name="mobileNo"
                    className="form-control"
                    value={this.state.mobileNo}
                    onChange={this.changeMobileNoHandler}
                  />
                </div>
                <div className="form-group">
                  <label>Status</label>
                  <input
                    placeholder="Status"
                    name="status"
                    className="form-control"
                    value={this.state.status}
                    onChange={this.changeStatusHandler}
                  />
                </div>
                <div className="form-group">
                  <label>Timing</label>
                  <input
                    placeholder="Timing"
                    name="timing"
                    className="form-control"
                    value={this.state.timing}
                    onChange={this.changeTimingHandler}
                  />
                </div>
                <div className="form-group">
                  <label>Date</label>
                  <input
                    placeholder="Date"
                    name="date"
                    className="form-control"
                    value={today}
                    onChange={this.changeDateHandler}
                  />
                </div>

                <button
                  className="btn btn-success"
                  onClick={this.updateGuardTraining}
                >
                  Save
                </button>

                <button
                  className="btn btn-danger"
                  onClick={this.cancel.bind(this)}
                  style={{ marginLeft: "10px" }}
                >
                  Cancel
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default UpdateGuardTrainingComponent;
