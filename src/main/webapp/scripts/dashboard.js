document.addEventListener("DOMContentLoaded", function() {
	const editButtons = document.querySelectorAll(".btn");
	const modal = document.getElementById("editModal");
	const closeModalButton = document.querySelector(".modal-content .close");

	editButtons.forEach((button) => {
		button.addEventListener("click", () => {
			modal.style.display = "block"; 
			modal.classList.add("active"); // Add the active class to show the modal
		});
	});

	closeModalButton.addEventListener("click", () => {
		modal.style.display = "none";
		modal.classList.remove("active"); // Remove the active class to hide the modal
	});

	window.addEventListener("click", (event) => {
		if (event.target === modal) {
			modal.style.display = "none"; 
			modal.classList.remove("active"); // Remove the active class to hide the modal
		}
	});
});