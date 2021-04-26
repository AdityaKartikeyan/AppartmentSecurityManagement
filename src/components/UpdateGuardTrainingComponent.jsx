import React, { Component } from "react";
import GuardTrainingService from "../services/GuardTrainingService";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
let today = new Date();
const regExp1 = RegExp(/^[0-9]+$/);
const regExp2 = RegExp(/^[0-9]+$/);

const formValid = ({ isError, ...rest }) => {
  let valid = true;

  Object.values(isError).forEach((val) => {
    val.length > 0 && (valid = false);
  });

  Object.values(rest).forEach((val) => {
    val == null && (valid = false);
  });

  return valid;
};
class UpdateGuardTrainingComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      userId: this.props.match.params.userId,
      createdBy: "",
      modifiedBy: "",
      id: "",
      name: "",
      mobileNo: "",
      status: "",
      timing: "",
      isError: {
        createdBy: "",
        modifiedBy: "",
        userId: "",
        name: "",
        mobileNo: "",
        status: "",
      },
      disabled: true,
    };
    this.changeCreatedByHandler = this.changeCreatedByHandler.bind(this);
    this.changeModifiedByHandler = this.changeModifiedByHandler.bind(this);
    this.changeIdHandler = this.changeIdHandler.bind(this);
    this.changeUserIdHandler = this.changeUserIdHandler.bind(this);
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
          createdBy: guards.createdBy,
          modifiedBy: guards.modifiedBy,
          id: guards.id,
          userId: guards.userId,
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
    if (formValid(this.state)) {
      let guards = {
        createdBy: this.state.createdBy,
        modifiedBy: this.state.modifiedBy,
        id: this.state.id,
        userId: this.state.userId,
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
          alert("Form is updated");
        }
      );
    } else {
      toast.error("Form is invalid", { position: "top-center" });
    }
  };
  changeCreatedByHandler = (event) => {
    this.setState({ createdBy: event.target.value });
  };
  changeModifiedByHandler = (event) => {
    this.setState({ modifiedBy: event.target.value });
  };
  changeUserIdHandler = (event) => {
    this.setState({ userId: event.target.value });
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
  formValChange = (e) => {
    e.preventDefault();
    const { name, value } = e.target;
    let isError = { ...this.state.isError };
    switch (name) {
      case "createdBy":
        isError.createdBy =
          value.length < 5 ? "Atleast 5 characters required" : "";
        break;
      case "modifiedBy":
        isError.modifiedBy =
          value.length < 5 ? "Atleast 5 characters required" : "";
        break;
      case "userId":
        isError.userId = regExp2.test(value) ? "" : "Numeric Values Required";
        break;
      case "name":
        isError.name = value.length < 5 ? "Atleast 5 characters required" : "";
        break;
      case "mobileNo":
        isError.mobileNo = regExp1.test(value) ? "" : "Number is Invalid";
        break;

      case "status":
        isError.status =
          value.length < 4 ? "Atleast 4 characters required" : "";
        break;

      default:
        break;
    }
    this.setState(
      {
        isError,
        [name]: value,
        disabled: false,
      },
      () => console.log(this.state)
    );
  };

  cancel() {
    this.props.history.push("/guardTraining");
  }
  render() {
    const { isError } = this.state;

    return (
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h3 className="text-center">Update Guard Training</h3>
            <div className="card-body">
              <form>
                <div className="form-group">
                  <label>Modified By</label>
                  <input
                    placeholder="modifiedBy"
                    name="modifiedBy"
                    className={
                      isError.modifiedBy.length > 0
                        ? "is-invalid form-control"
                        : "form-control"
                    }
                    value={this.state.modifiedBy}
                    noValidate
                    onChange={
                      (this.changeModifiedByHandler, this.formValChange)
                    }
                  />
                  {isError.modifiedBy.length > 0 && (
                    <span className="invalid-feedback">
                      {isError.modifiedBy}
                    </span>
                  )}
                </div>
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
                  <label>UserId</label>
                  <input
                    placeholder="userId"
                    name="userId"
                    className={
                      isError.userId.length > 0
                        ? "is-invalid form-control"
                        : "form-control"
                    }
                    value={this.state.userId}
                    onChange={(this.changeUserIdHandler, this.formValChange)}
                  />
                  {isError.userId.length > 0 && (
                    <span className="invalid-feedback">{isError.userId}</span>
                  )}
                </div>
                <div className="form-group">
                  <label>Name</label>
                  <input
                    placeholder="Name"
                    name="name"
                    className={
                      isError.name.length > 0
                        ? "is-invalid form-control"
                        : "form-control"
                    }
                    value={this.state.name}
                    onChange={(this.changeNameHandler, this.formValChange)}
                  />
                  {isError.name.length > 0 && (
                    <span className="invalid-feedback">{isError.name}</span>
                  )}
                </div>
                <div className="form-group">
                  <label>Mobile No</label>
                  <input
                    placeholder="Mobile No"
                    name="mobileNo"
                    className={
                      isError.mobileNo.length > 0
                        ? "is-invalid form-control"
                        : "form-control"
                    }
                    value={this.state.mobileNo}
                    onChange={(this.changeMobileNoHandler, this.formValChange)}
                  />
                  {isError.mobileNo.length > 0 && (
                    <span className="invalid-feedback">{isError.mobileNo}</span>
                  )}
                </div>
                <div className="form-group">
                  <label>Status</label>
                  <input
                    placeholder="Status"
                    name="status"
                    className={
                      isError.status.length > 0
                        ? "is-invalid form-control"
                        : "form-control"
                    }
                    value={this.state.status}
                    onChange={(this.changeStatusHandler, this.formValChange)}
                  />
                  {isError.status.length > 0 && (
                    <span className="invalid-feedback">{isError.status}</span>
                  )}
                </div>
                <div className="form-group">
                  <label>Timing </label>
                  <br></br>
                  <select
                    className="form-control"
                    name="timing"
                    id="timing"
                    value={this.state.timing}
                    noValidate
                    onChange={this.changeTimingHandler}
                  >
                    <option value="9.00"> 9 am</option>
                    <option value="10.30">10.30 am</option>
                    <option value="11.30">11.30 am</option>
                    <option value="12.30">12.30 pm</option>
                    <option value="13.30">1.30 pm</option>
                    <option value="14.30">2.30 pm</option>
                    <option value="15.30">3.30 pm</option>
                    <option value="16.30">4.30 pm</option>
                    <option value="17.30">5.30 pm</option>
                    <option value="18.30">6.30 pm</option>
                  </select>
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
                  disabled={this.state.disabled}
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
        <ToastContainer />
      </div>
    );
  }
}

export default UpdateGuardTrainingComponent;
