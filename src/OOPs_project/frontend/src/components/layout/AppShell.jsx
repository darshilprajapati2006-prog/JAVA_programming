import { useState } from "react";
import Sidebar from "./Sidebar";
import Topbar from "./Topbar";

export default function AppShell({ children }) {
  const [mobileOpen, setMobileOpen] = useState(false);

  return (
    <div className="min-h-screen bg-transparent md:grid md:grid-cols-[288px_1fr]">
      <Sidebar mobileOpen={mobileOpen} onClose={() => setMobileOpen(false)} />
      <div className="page-shell md:px-8 md:py-6 xl:px-10">
        <div className="content-wrap space-y-6">
          <Topbar onOpenSidebar={() => setMobileOpen(true)} />
          <main>{children}</main>
        </div>
      </div>
    </div>
  );
}
