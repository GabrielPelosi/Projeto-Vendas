import DataTable from "components/DataTable";
import Footer from "components/Footer";
import NavBar from "components/NavBar";


function App() {
  return (
    <>
      <div>
        <NavBar />
        <h1 className="text-primary">Olá Mundo!</h1>
        <DataTable/>
        <Footer/>
      </div>
    </>
  );
}

export default App;
