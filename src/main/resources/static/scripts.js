function submitResume() {
    const formData = new FormData(document.getElementById('resumeForm'));
    fetch('/api/resumes/create', {
        method: 'POST',
        body: formData
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error creating resume');
            }
            return response.json();
        })
        .then(data => {
            // Обработка успешного создания резюме
        })
        .catch(error => {
            console.error('Error:', error);
        });
}