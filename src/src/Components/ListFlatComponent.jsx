import React, { Component } from "react";
import FlatService from "../services/FlatService";

class ListFlatComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      flat: [],
    };
    this.addFlat = this.addFlat.bind(this);
    this.editFlat = this.editFlat.bind(this);
    this.deleteFlat = this.deleteFlat.bind(this);
  }
  baseEntity(flatNo) {
    this.props.history.push(`/getByPk/${flatNo}`);
  }
  editFlat(flatNo) {
    this.props.history.push(`/updateFlat/${flatNo}`);
  }
  componentDidMount(){
      FlatService.getFlat().then((res) => {
            this.setState({flat: res.data});
      });
  }
  addFlat() {
    this.props.history.push('/addFlat');
  }
   viewFlat(flatNo) {
    this.props.history.push(`/getById/${flatNo}`);
    
  }
  deleteFlat(id) {
    FlatService.deleteFlat(id).then(res => {
      this.setState({ flat: this.state.flat.filter(flat => flat.id !== id) });
    });
}


  render() {
    return (
      <div>
        <h2 className="text-center">FlatList</h2>
        <div className="row">
          <button className="btn btn-primary" onClick={this.addFlat}>
            Add Flat
          </button>
        </div>
        <br></br>
        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th>Owner Name</th>
                <th>Flat No</th>
                <th>Floor No</th>
                <th>Flat Type</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {this.state.flat.map((flat) => (
                <tr key={flat.flatNo}>
                  
                  <td>{flat.ownerName}</td>
                  <td>{flat.flatNo}</td>
                  <td>{flat.floorNo}</td>
                  <td>{flat.flatType}</td>
                  <td><button onClick={() => this.editFlat(flat.flatNo)} className="btn btn-info">Update</button>
                    <button style={{ marginLeft: "10px" }} onClick={() => this.deleteFlat(flat.id)} className="btn btn-danger">Delete</button>
                    <button style={{ marginLeft: "10px" }} onClick={() => this.viewFlat(flat.flatNo)} className="btn btn-info">
                      View</button>
                    <button
                      style={{ marginLeft: "10px" }}
                      onClick={() => this.baseEntity(flat.flatNo)}
                      className="btn btn-info"
                    >
                      Audit
                    </button>
                    </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ListFlatComponent;