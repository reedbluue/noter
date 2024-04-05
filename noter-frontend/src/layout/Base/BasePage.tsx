import {Outlet} from "react-router-dom";
import {Toaster} from "react-hot-toast";

export const BasePage = () => {
  return (
      <div>
        <Outlet/>
        <Toaster/>
      </div>
  );
}